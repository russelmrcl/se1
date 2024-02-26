package org.hbrs.se1.ws23.uebung02;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private static List<Member> memberList = new ArrayList<>();

    public void addMember(Member newMember) throws ContainerException {
        for (Member member: memberList) {
            if (member.getID().equals(newMember.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + newMember.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(newMember);
    }

    public String deleteMember(Integer id)  {

        if (memberList.isEmpty()) {
           throw new IllegalArgumentException("Die Liste is leer");
        }
        for (Member member : memberList) {
            if (member.getID().equals(id)) {
                memberList.remove(member);
                return "Member-Objekt gelöscht!";
            }
        }
        throw new IllegalArgumentException("Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!");
    }

    public void dump() {
        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }

    public int size() {
        return memberList.size();
    }
}
