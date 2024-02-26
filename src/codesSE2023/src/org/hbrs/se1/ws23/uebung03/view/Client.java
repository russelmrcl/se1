package org.hbrs.se1.ws23.uebung03.view;

import org.hbrs.se1.ws23.uebung03.ConcreteMember;
import org.hbrs.se1.ws23.uebung03.Container;
import org.hbrs.se1.ws23.uebung03.ContainerException;

public class Client {

    public void display(Container container, MemberView memberView) throws ContainerException {
        try {
            container.addMember(new ConcreteMember(1));
            container.addMember(new ConcreteMember(10));
            container.addMember(new ConcreteMember(24));
            container.addMember(new ConcreteMember(5));
        } catch (ContainerException containerException) {
            throw new ContainerException("Failed!");
        }

        memberView.dump(container.getCurrentList());
    }

}
