package m.srinivas.campstar;

public class Groups {
    String groupname;
    int pavan;
    Groups(String groupname,int pavan){
        this.groupname = groupname;this.pavan = pavan;
    }

    public int getPavan() {
        return pavan;
    }

    public void setPavan(int pavan) {
        this.pavan = pavan;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
