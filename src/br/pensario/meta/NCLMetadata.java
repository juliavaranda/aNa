package br.pensario.meta;


/**
 * Esta classe define o elemento <i>metadata</i> da <i>Nested Context Language</i> (NCL).
 * Este elemento é o elemento que define uma árvore RDF de metadados para o documento NCL.<br>
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
public class NCLMetadata {

    private String rdfTree;


    /**
     * Determina a árvore RDF de metadados do elemento metadata.
     *
     * @param rdfTree
     *          String representando a árvore RDF.
     * @throws IllegalArgumentException
     *          se a String for vazia.
     */
    public void setRDFTree(String rdfTree) throws IllegalArgumentException {
        if (rdfTree != null && "".equals(rdfTree.trim()))
            throw new IllegalArgumentException("Empty String");

        this.rdfTree = rdfTree;
    }


    /**
     * Retorna a árvore RDF de metadados do elemento metadata.
     *
     * @return
     *          String representando a árvore RDF.
     */
    public String getRDFTree() {
        return rdfTree;
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
        content = space + "<metadata>\n";

        content += getRDFTree();

        content += "</metadata>\n";

        return content;
    }
}
