package skillbox.amkiri.module5.hw4;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

class PhoneNumUtils {

    private PhoneNumUtils(){}

    // just russian
    static boolean isPhoneNumber(String str) {
        return str
                .replaceAll("[ \\-()]", "")
                .matches("^((\\+7|7|8)+([0-9]){10})$");
    }

    static String format(String phoneNum) throws ParseException {
        MaskFormatter maskFormatter = new MaskFormatter("# ### ###-##-##");
        maskFormatter.setValueContainsLiteralCharacters(false);

        return maskFormatter
                .valueToString(
                        phoneNum.replaceAll("[ +\\-()]", "")
                );
    }

    static String printPhoneBookEntry(String name, String phoneNum) {
        return name + "\t--->\t" + phoneNum;
    }
}
