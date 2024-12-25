package com.emsi;

public class DwarvenCartOperator extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println("{} moves gold chunks out of the mine." + name());
    }

    @Override
    public String name() {
        return "Dwarf cart operator";
    }
}