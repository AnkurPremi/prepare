package DataStructures.NewWork.LCStrings;

public class ReadBuffer {
    public static void main(String[] args) {
        ReadBuffer readBuffer = new ReadBuffer();
        char[] buf = new char[4];
        System.out.println(readBuffer.read(buf, 1));
        System.out.println(readBuffer.read(buf, 2));
        System.out.println(readBuffer.read(buf, 3));
    }

    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) break;
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            if (buffPtr >= buffCnt) buffPtr = 0;
        }
        return ptr;
    }

    char[] arr = "abcdef".toCharArray();
    int j = 0;
    private int read4(char[] buff){
        int prevJ = j;
        for(int i = 0; j < arr.length &&  i < 4 ; i++){
            buff[i] = arr[j++];
        }
        return j - prevJ;
    }
}
