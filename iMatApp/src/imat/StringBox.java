package imat;

public class StringBox {
    public String strBox ="";
    public int min;
    public int max;
    public boolean onlyAcceptNumber;
    public boolean onlyAcceptNoneSpecialChar;

    public String OnlyAcceptNoneSpecialCharList;
    public StringBox(int min, int max, boolean onlyAcceptNumber, boolean onlyAcceptNoneSpecialChar)
    {
        this.min = min;
        this.max = max;
        this.onlyAcceptNumber = onlyAcceptNumber;
        this.onlyAcceptNoneSpecialChar = onlyAcceptNoneSpecialChar;
        this.OnlyAcceptNoneSpecialCharList="qwertyuiopåasdfghjklöäzxcvbnm1234567890@'-";
    }

    void errorBox(String Message){
        //error(Message) ska printa felmedelandet i rött ovanför rutan ovanför.
        System.out.print(Message);
    }

    String getStrBox(){
        return strBox;
    }
    void updateStrBox(String newStrbox){
        this.strBox=newStrbox;
    }
    void emptyBox(){
        this.strBox="";
    }

    void confirmBox(){
        if (onlyAcceptNumber)
            for(int i = 0; i < strBox.length(); i++)
                if (strBox.charAt(i) < '0' || strBox.charAt(i) > '9') {
                    errorBox("Vänligen skriv bara siffror 0-9");
                    break;
                }
        else if(onlyAcceptNoneSpecialChar){
            for(int a = 0; a < strBox.length(); a++){
                if (OnlyAcceptNoneSpecialCharList.indexOf(strBox.toLowerCase().charAt(i))==-1){
                    errorBox("Vänligen skriv inga specialtecken");
                    break;
                }
            }
        }

        else if ((strBox.length() < min) || (strBox.length() > max)){
            if (min == max){
                errorBox("Vänligen skriv "+max+" siffror");}
            else {
                errorBox("Skriv "+min+"-"+max+" karaktärer");
            }
        }

    }
}
//test