package my.samples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Base64Encoder {
 private static final int BUFFER_SIZE = 1024;
 private static byte[] encoding = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47, 61};
 InputStream in = null;
 OutputStream out = null;
 boolean stringp = false;

 private final int get1(byte[] buf, int off) {
     return (buf[off] & 252) >> 2;
 }

 private final int get2(byte[] buf, int off) {
     return (buf[off] & 3) << 4 | (buf[off + 1] & 240) >>> 4;
 }

 private final int get3(byte[] buf, int off) {
     return (buf[off + 1] & 15) << 2 | (buf[off + 2] & 192) >>> 6;
 }

 private static final int get4(byte[] buf, int off) {
     return buf[off + 2] & 63;
 }

 public void process() throws IOException {
     byte[] buffer = new byte[1024];
     //int got = 0;
     int off = 0;
     int count = 0;

     while(true) {
         int got;
         while((got = this.in.read(buffer, off, 1024 - off)) > 0) {
             if (got + off >= 3) {
                 got += off;

                 int i;
                 for(off = 0; off + 3 <= got; off += 3) {
                     i = this.get1(buffer, off);
                     int c2 = this.get2(buffer, off);
                     int c3 = this.get3(buffer, off);
                     int c4 = get4(buffer, off);
                     switch(count) {
                     case 73:
                         this.out.write(encoding[i]);
                         this.out.write(encoding[c2]);
                         this.out.write(encoding[c3]);
                         this.out.write(10);
                         this.out.write(encoding[c4]);
                         count = 1;
                         break;
                     case 74:
                         this.out.write(encoding[i]);
                         this.out.write(encoding[c2]);
                         this.out.write(10);
                         this.out.write(encoding[c3]);
                         this.out.write(encoding[c4]);
                         count = 2;
                         break;
                     case 75:
                         this.out.write(encoding[i]);
                         this.out.write(10);
                         this.out.write(encoding[c2]);
                         this.out.write(encoding[c3]);
                         this.out.write(encoding[c4]);
                         count = 3;
                         break;
                     case 76:
                         this.out.write(10);
                         this.out.write(encoding[i]);
                         this.out.write(encoding[c2]);
                         this.out.write(encoding[c3]);
                         this.out.write(encoding[c4]);
                         count = 4;
                         break;
                     default:
                         this.out.write(encoding[i]);
                         this.out.write(encoding[c2]);
                         this.out.write(encoding[c3]);
                         this.out.write(encoding[c4]);
                         count += 4;
                     }
                 }

                 for(i = 0; i < 3; ++i) {
                     buffer[i] = i < got - off ? buffer[off + i] : 0;
                 }

                 off = got - off;
             } else {
                 off += got;
             }
         }

         switch(off) {
         case 1:
             this.out.write(encoding[this.get1(buffer, 0)]);
             this.out.write(encoding[this.get2(buffer, 0)]);
             this.out.write(61);
             this.out.write(61);
             break;
         case 2:
             this.out.write(encoding[this.get1(buffer, 0)]);
             this.out.write(encoding[this.get2(buffer, 0)]);
             this.out.write(encoding[this.get3(buffer, 0)]);
             this.out.write(61);
         }

         return;
     }
 }

 public String processString() throws IOException {
     if (!this.stringp) {
         throw new RuntimeException(this.getClass().getName() + "[processString]" + "invalid call (not a String)");
     } else {
         this.process();
         return ((ByteArrayOutputStream)this.out).toString();
     }
 }

 public Base64Encoder(String input) {
     byte[] bytes;
     try {
         //bytes = input.getBytes("ISO-8859-1");
         bytes = input.getBytes("UTF-8");
     } catch (UnsupportedEncodingException var4) {
         throw new RuntimeException(this.getClass().getName() + "[Constructor] Unable to convert" + "properly char to bytes");
     }

     this.stringp = true;
     this.in = new ByteArrayInputStream(bytes);
     this.out = new ByteArrayOutputStream();
 }

 public Base64Encoder(String input, String encoding) {
     byte[] bytes;
     try {
         bytes = input.getBytes(encoding);
     } catch (UnsupportedEncodingException var5) {
         throw new RuntimeException(this.getClass().getName() + "[Constructor] Unable to convert" + "properly char to bytes");
     }

     this.stringp = true;
     this.in = new ByteArrayInputStream(bytes);
     this.out = new ByteArrayOutputStream();
 }

 public Base64Encoder(byte[] bytes) {
     this.stringp = true;
     this.in = new ByteArrayInputStream(bytes);
     this.out = new ByteArrayOutputStream();
 }

 public Base64Encoder(InputStream in, OutputStream out) {
     this.in = in;
     this.out = out;
     this.stringp = false;
 }
}
