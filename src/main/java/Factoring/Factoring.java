package Factoring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Factoring {
private Integer tableSize;
private Integer whichOneMax;
private List <Integer> table = new ArrayList();
    public Factoring() {

    }
    public List<Integer> getLookingForNumbers() {
        List<Integer> workingTable = new ArrayList<>();
        for (int i =0; i<table.size(); i++) {
            int controlNumber=0;
            for (int o=1; o<table.get(i)+1;o++) {
                if (table.get(i)%o==0) {
                    controlNumber++;
                }
                if (controlNumber==4) {
                    workingTable.add(table.get(i));
                }
            }
        }
        return workingTable.stream().sorted().collect(Collectors.toList());
    }

    public String firstLine(String source) {
        String input = source.trim();
        tableSize = null;
        if (input.matches("[0-9]*") && Integer.valueOf(input) > 0 ) {
                    tableSize = Integer.valueOf(input);
        }
        if (tableSize == null) {
            return "Wrong format! Write only one(1) number!";
        }
        return "Correct";
    }

    public String secondLine(String inputTable) {
        table.clear();
        String[] splitTable = inputTable.split(" ");
        for (int i = 0; i < splitTable.length; i++) {
            if (splitTable[i].matches("[0-9]*") && splitTable.length == tableSize && Integer.valueOf(splitTable[i])<10000000) {
                table.add(Integer.valueOf(splitTable[i]));
            }

        }
        if(splitTable.length!=tableSize) {
            return "Incorrect number of numbers! You set size table as "+tableSize+" but you give "+splitTable.length+" numbers";
        }

        if (table.size()!=tableSize) {
            return "Incorrect format, write only numbers from 0 to 10 000 000!";
        }

        if(table.isEmpty()) {

            return "Incorrect format, write only numbers from 0 to 10 000 000!";
        }
        return "Correct";
    }


    public Integer getTableSize() {
        return tableSize;
    }

    public Integer getWhichOneMax() {
        return whichOneMax;
    }

    public List getTable() {
        return table;
    }
}
