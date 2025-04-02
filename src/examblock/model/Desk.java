package examblock.model;

public class Desk {
    private String FamilyName;
    private String GivenName;
    private int Number;
    // could add an exam maybe ??
    // since for each different venue we "create" the new desk instances

    public Desk(int deskNumber){
        this.GivenName = null;
        this.FamilyName = null;
        this.Number = deskNumber;
    }

    public Desk(int deskNumber, String familyName, String givenName){
        this.GivenName =givenName ;
        this.FamilyName = familyName;
        this.Number = deskNumber;
    }
    public String deskFamilyName() {
        return this.FamilyName;
    }

    public String deskGivenAndInit(){
        String total = new String (this.GivenName + " ");
        total =  total +Character.toString(this.FamilyName.charAt(0)) ;
        // gest first given name + initial of student

        return total;
    }

    public int deskNumber() {
        return this.Number;
    }

//    @Override
//    public String toString() {
//
//        if ( this.FamilyName != null && this.GivenName != null) {
//            return "Desk{" +
//                    "FamilyName='" + FamilyName + '\'' +
//                    ", GivenName='" + GivenName + '\'' +
//                    ", Number=" + Number +
//                    '}';
//        } else {
//            return "Desk{" +
//                    ", Number=" + Number +
//                    '}';
//        }
//
//    }

    @Override
    public String toString() {
//        if (this.FamilyName.equals("Empty")) {
//            return " ";
//        }
//        return String.format("%s%n%s", this.FamilyName, this.GivenName);

        StringBuilder sb = new StringBuilder();
        sb.append(" Desk : " + this.Number).append("\n" + this.FamilyName).append("\n" + this.GivenName);
        return  sb.toString();
    }
}
