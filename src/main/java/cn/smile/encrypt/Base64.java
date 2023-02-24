package cn.smile.encrypt;

/**
 * @author zhanglei19corp.netease.com
 * @date 2020-10-27 2:26 下午
 */

import java.io.ByteArrayOutputStream;

/**
 * Base64 encoder and decoder, block version.
 * While encoding, user need to create an object for each encoding task.
 *
 * @author konglh
 * @modifier zhufx
 *
 */
public class Base64 {
    private static final int MAX_LINE_LEN = 76;

    private static char[] base64EncodeChars = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private static byte[] base64DecodeChars = new byte[]{
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57,
            58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1,
            -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
            39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1
    };

    public Base64() {
    }

    /**
     * @param data data buffer to encode
     * @return the encoded string
     */
    public static String encode(byte[] data) {
        return encode(data, data.length);
    }

    /**
     * @param data   data buffer to encode
     * @param length length of the data to encode, used to encode part of a buffer,
     *               need (length % 3 == 0) except the last buffer
     * @return the encoded string
     */
    public static String encode(byte[] data, int length) {
        StringBuffer sb = new StringBuffer();
        int len = length;
        int i = 0;
        int charcnt = 0;
        int b1, b2, b3;

        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4)
                        | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4)
                    | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2)
                    | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);

            /*
             * Add /r/n every MAX_LINE_LEN chars according to
             * Base64 transfer encoding for MIME (RFC 2045)
             */
            charcnt += 4;
            if (charcnt == MAX_LINE_LEN) {
                sb.append('\r');
                sb.append('\n');
                charcnt = 0;    // reset counter to count new line
            }
        }

        return sb.toString();
    }

    /**
     * @param str string to decode
     * @return decoded data
     */
    public static byte[] decode(String str) {
        return decode(str.getBytes());
    }

    /**
     * @param data data buffer to decode
     * @return decoded data
     */
    public static byte[] decode(byte[] data) {
        int len = data.length;
        ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
        int i = 0;
        int cnt = 0;
        int b1, b2, b3, b4;

        // process 4 bytes each time
        while (i < len) {
            /* b1 */
            do {
                b1 = base64DecodeChars[data[i++]];
            } while (i < len && b1 == -1);
            if (b1 == -1) {
                break;
            }

            /* b2 */
            do {
                b2 = base64DecodeChars[data[i++]];
            } while (i < len && b2 == -1);
            if (b2 == -1) {
                break;
            }
            buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));

            /* b3 */
            do {
                b3 = data[i++];
                if (b3 == 61) {
                    return buf.toByteArray();
                }
                b3 = base64DecodeChars[b3];
            } while (i < len && b3 == -1);
            if (b3 == -1) {
                break;
            }
            buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));

            /* b4 */
            do {
                b4 = data[i++];
                if (b4 == 61) {
                    return buf.toByteArray();
                }
                b4 = base64DecodeChars[b4];
            } while (i < len && b4 == -1);
            if (b4 == -1) {
                break;
            }
            buf.write((int) (((b3 & 0x03) << 6) | b4));

            // skip /r/n
            cnt += 4;
            if (cnt == MAX_LINE_LEN) {
                i += 2;
                cnt = 0;        // reset counter
            }
        }
        return buf.toByteArray();
    }
}
