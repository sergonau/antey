/**
 * Created by Sergey on 04.08.16.
 */
public class Main {
    public static void main(String[] args) {
        checkIds();
    }

    private static void checkIds() {
        for (IdProvider validated : IdProvider.values()) {
            if (validated.mId.length() < 10) try {
                throw new Exception((String.format("%s id length < 10", validated.ordinal())));
            } catch (Exception e) {e.printStackTrace();}
            if (validated.mId.matches(".*[a-zA-Z]+.*")) try {
                throw new Exception(String.format("%s id contains string", validated.ordinal()));
            } catch (Exception e) {e.printStackTrace();}
        }
    }

    public enum IdProvider {
        one("9999999999"),
        two("7777777777"),
        three("888888"),
        four("1111111111"),
        five("2222222222"),
        six("3333333333"),
        seven("4444444444"),
        eight("5555555"),
        nine("vfnfggn"),
        ten("00000000000");

        private IdProvider(String id) {
            mId = id;
        }

        String mId;
    }


}
