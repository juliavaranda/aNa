package br.pensario.rule;

import br.pensario.NCLIdentifiableElement;
import br.pensario.NCLValues.NCLComparator;
import br.pensario.interfaces.NCLProperty;


/**
 * Esta classe define uma regra de teste da <i>Nested Context Language</i> (NCL).<br>
 *
 * @see <a
 *      href="http://www.abnt.org.br/imagens/Normalizacao_TV_Digital/ABNTNBR15606-5_2008Ed1.pdf">ABNT
 *      NBR 15606-5:2008</a>
 *
 *
 * @version 1.0.0
 * @author <a href="http://joel.dossantos.eng.br">Joel dos Santos<a/>
 * @author <a href="http://www.cos.ufrj.br/~schau/">Wagner Schau<a/>
 */
public class NCLRule<P extends NCLProperty, T extends NCLTestRule> extends NCLIdentifiableElement implements NCLTestRule<T> {

    private P var;
    private NCLComparator comparator;
    private String value;


    /**
     * Atribui uma propriedade ao atributo var.
     *
     * @param var
     *          elemento representando a propriedade associada ao atributo.
     */
    public void setVar(P var) {
        this.var = var;
    }


    /**
     * Retorna a propriedade relacionada ao atributo var.
     *
     * @return
     *          elemento representando a propriedade associada ao atributo.
     */
    public P getVar() {
        return var;
    }


    /**
     * Atribui um comparador a regra.
     *
     * @param comparator
     *          elemento representando o comparador da regra.
     */
    public void setComparator(NCLComparator comparator) {
        this.comparator = comparator;
    }


    /**
     * Retorna o comparador da regra.
     *
     * @return
     *          elemento representando o comparador da regra.
     */
    public NCLComparator getComparator() {
        return comparator;
    }


    /**
     * Atribui um valor de comparação a regra.
     *
     * @param value
     *          String representando o valor de comparação.
     *
     * @throws IllegalArgumentException
     *          se a String for vazia.
     */
    public void setValue(String value) throws IllegalArgumentException {
        if (value != null && "".equals(value.trim()))
            throw new IllegalArgumentException("Empty String");

        this.value = value;
    }


    /**
     * Retorna o valor de comparação da regra.
     *
     * @return
     *          String representando o valor de comparação.
     */
    public String getValue() {
        return value;
    }
    

    public String parse(int ident) {
        String space, content;

        if(ident < 0)
            ident = 0;

        // Element indentation
        space = "";
        for(int i = 0; i < ident; i++)
            space += "\t";


        // param element and attributes declaration
        content = space + "<rule";
        content += " id='" + getId() + "'";
        content += " var='" + getVar() + "'";
        content += " comparator='" + getComparator() + "'";
        content += " value='" + getValue() + "'";
        content += "/>\n";

        return content;
    }


    public int compareTo(T other) {
        return getId().compareTo(other.getId());
    }
}
