package org.hbrs.se1.ws23.uebung03;

public class ConcreteMember implements Member {

    private Integer memberID;


    public ConcreteMember(Integer memberID) {
        this.memberID = memberID;
    }

    @Override
    public Integer getID() {
        return memberID;
    }

    @Override
    public String toString() {
        return "Member " +
                "(ID = [" + memberID +
                "])";
    }
}
