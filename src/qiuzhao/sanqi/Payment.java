package qiuzhao.sanqi;

/**
 * Created by Huangsky on 2018/9/6.
 */
class NimoBaseException extends Exception {
}

class CustomException extends NimoBaseException {
}

class Payment {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new CustomException();
            } catch (NimoBaseException a) {
                System.out.println("NimoBaseException Invoked!!");
                throw a;
            }
        } catch (CustomException C) {
            System.out.println("CustomException Invoked!!");
            return;
        } finally {
            System.out.println("Hello Payment.");
        }
    }
}
