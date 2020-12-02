package co.in.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * Created by s.sreenivasan on 1/23/2016.
 */
@AllArgsConstructor
@EqualsAndHashCode(of = "symbol")
@ToString(of = "symbol")
public class RomanSymbol {
    @Getter(AccessLevel.PACKAGE)
    private final Character symbol;
    @Getter
    private final Boolean isRepeatable;
    @Getter
    private final Boolean isSubtractable;
    @Getter
    private final List<RomanSymbol> subtractableFrom;
    @Getter
    private final Integer value;

    final static RomanSymbol ZERO = ZeroSymbol();

    public static RomanSymbol StandaloneSymbol(Character symbol,Integer value){
        return new RomanSymbol(symbol,Boolean.FALSE,Boolean.FALSE, Collections.emptyList(),value);
    }

    public static RomanSymbol RepeatableAndSubtractableSymbol(Character symbol,List<RomanSymbol> subtractableFrom,Integer value){
        return new RomanSymbol(symbol,Boolean.TRUE,Boolean.TRUE, subtractableFrom,value);
    }

    static RomanSymbol ZeroSymbol(){
        return new RomanSymbol('Z',Boolean.FALSE,Boolean.FALSE, Collections.emptyList(),0);
    }
    public boolean sameSymbol(Character symbol){
        return this.symbol.equals(symbol);
    }

}
