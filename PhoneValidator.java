public class PhoneValidator {
    public static boolean validate(String phoneNumber) {
        String[] formats = {"(###) ###-####", "###-###-####"};
        for (String format : formats) {
            String pattern = format.replaceAll("#", "\\\\d");
            if (phoneNumber.matches(pattern)) {
                return true;
            }
        }
        return false;
    }
}
