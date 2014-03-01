package lab9;

import java.util.Random;

public final class RandomNameGenerator {
    private final int ASCII_A = 65;
    private final int ASCII_a = 97;
    private final int ASCII_SPACE = 32;
    private final int ALPHABET_SIZE = 26;
    private final int MIN_NAME_LENGTH = 14; // arbitrary choice

    public String getRandomName()
    {
        Random random = new Random();
        byte[] bytes = new byte[24];
        String s;
        random.nextBytes(bytes);
        // convert the bytes to 97..126 to make lower case letters
        for (int j = 0; j < bytes.length; j++) {
            bytes[j] = (byte)(Math.abs(bytes[j])%ALPHABET_SIZE + ASCII_a);
        }
        // set string total length to range 14..24
        int length = MIN_NAME_LENGTH + random.nextInt(10);
        // put a space somewhere from 4 to length - 4
        int spaceLocation = 4 + random.nextInt(length-8);
        bytes[spaceLocation] = ASCII_SPACE; // insert a space
        bytes[0] -= (ASCII_a-ASCII_A); // make first letter upper case
        bytes[spaceLocation+1] -= (ASCII_a-ASCII_A); // letter after space uppercase
        s = new String(bytes);
        return s.substring(0,length);
    }

}