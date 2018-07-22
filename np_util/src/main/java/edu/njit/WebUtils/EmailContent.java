package edu.njit.WebUtils;
import java.security.SecureRandom;

public class EmailContent {
    private static SecureRandom random;
    private static final char[] CHARS={
            'A','E','F','G','H','2','3','4','5','6','7','8','J','L','M','N','P','Q','R',
            'S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','j','m','n','p','r',
            's','t','u','v','w','x','y','z','B','C','D',
    };
    static{
        random = new SecureRandom();
    }

    public static String VerificationCodes()
    {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<Const.emailLen;i++)
        {
            sb.append(CHARS[random.nextInt(CHARS.length)]);
        }

        return sb.toString();
    }


}

