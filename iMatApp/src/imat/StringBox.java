package imat;

public class StringBox {
    public String strBox ="";
    public int min;
    public int max;
    public boolean number;
    public boolean special;
    public StringBox(int mIn, int mAx, boolean nUmber, boolean sPecial)
    {
        min = mIn;
        max = mAx;
        number = nUmber;
        special = sPecial;
    }

    void errorBox(String Message){
        //error(Message) ska printa felmedelandet i rött ovanför rutan ovanför.
        System.out.print(Message);
    }

    String getStrBox(){
        return strBox;
    }

    void emptyBox(){
        strBox="";
    }

    void confirmBox(){
        if (number)
            for(int i = 0; i < strBox.length(); i++)
                if (strBox.charAt(i) < '0' || strBox.charAt(i) > '9') {
                    errorBox("Vänligen skriv bara siffror 0-9");
                    break;
                }
        if ((strBox.length() < min) || (strBox.length() > max)){

        }
    }
}
