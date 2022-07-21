package starter.Helper;


import org.apache.commons.lang3.RandomStringUtils;

public class Main {

    public String randomCharacter(Integer lengthChar, Boolean type) {
        if (!type) {
            return RandomStringUtils.randomAlphabetic(lengthChar);
        } else{
            return RandomStringUtils.randomAlphanumeric(lengthChar);
        }
    }
}
