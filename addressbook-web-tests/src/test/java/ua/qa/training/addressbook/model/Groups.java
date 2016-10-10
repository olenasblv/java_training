package ua.qa.training.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by osoboleva on 10/9/2016.
 */
//контейнер для хранения множества групп
public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate());
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group){ // делает копию
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupData group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
