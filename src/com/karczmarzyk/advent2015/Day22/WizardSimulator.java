package com.karczmarzyk.advent2015.Day22;

import java.util.List;
import java.util.stream.Collectors;

public class WizardSimulator {

    private static List<List<String>> getCombinationsOfSpells()
    {
        SpellCombinations spellCombinations = new SpellCombinations();
        spellCombinations.addFirstFive();
        spellCombinations.addNewSpells(  spellCombinations.addFirstFive(),9 );
        return spellCombinations.getFullList();
    }

    public static void main(String[] args) {

        List<List<String>> combinations = WizardSimulator.getCombinationsOfSpells();
        int minimum = combinations.stream()
                .mapToInt( WizardSimulator::fightResult )
                .filter( s -> s > 0 )
                .min()
                .orElse( -20 );
        System.out.println( "minimum = " + minimum );
        System.out.println( "combinations.size() = " + combinations.size() );
    }

    public static int fightResult(List<String> spells)
    {
        Wizard wizard = new Wizard( 50,500 );
        Fight fight = new Fight( wizard );
        fight.setBossHP( 55 );
        fight.addSpellList( spells );
        return fight.fightResult();
    }

    public static String fightResultString(List<String> spells)
    {
        Wizard wizard = new Wizard( 50,500 );
        Fight fight = new Fight( wizard );
        fight.setBossHP( 55 );
        fight.addSpellList( spells );
        int result = fight.fightResult();
        if(result > 0)
        {
//            System.out.println( "result+ spells = " + result +" "+ spells );
            return result+ " " + spells;
        }else
            return "";
    }
}
