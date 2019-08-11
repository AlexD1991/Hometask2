import util.Validator;

public class TestRunner {

    public static void main(String[] args){
        System.out.println(Validator.isEmailValid("test@wewe.we") +" "+
                Validator.isEmailValid("test@.sd.sd.asd")+" "+
                Validator.isEmailValid("@we.we"));

        //StudentsList st = new StudentsList();
        //st.printList();
    }
}
