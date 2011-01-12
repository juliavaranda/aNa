package br.pensario.descriptor;

import java.util.Set;
import java.util.TreeSet;

import br.pensario.NCLIdentifiableElement;
import br.pensario.reuse.NCLImport;


/**
 * Esta classe define o elemento <i>descriptorBase</i> da <i>Nested Context Language</i> (NCL).
 * Este elemento é o elemento que define uma base de descritores de um documento NCL.<br>
 *
 * @see <a
 *      href="http://www.abnt.org.br/imagens/Normalizacao_TV_Digital/ABNTNBR15606-5_2008Ed1.pdf">ABNT
 *      NBR 15606-5:2008</a>
 *
 *
 * @version 1.0.0
 * @author <a href="http://www.cos.ufrj.br/~schau/">Wagner Schau<a/>
 * @author <a href="http://joel.dossantos.eng.br">Joel dos Santos<a/>
 */
public class NCLDescriptorBase<D extends NCLLayoutDescriptor, I extends NCLImport> extends NCLIdentifiableElement {

    private Set<D> descriptors = new TreeSet<D>();
    private Set<I> imports = new TreeSet<I>();


    /**
     * Adiciona um descritor à base de descritores.
     * 
     * @param descriptor
     *          elemento representando o descritor a ser adicionado.
     *
     * @see TreeSet#add
     */
    public boolean addDescriptor(D descriptor) {
        return descriptors.add(descriptor);
    }


    /**
     * Remove um descritor da base de descritores.
     *
     * @param id
     *          identificador do descritor a ser removido.
     * @return
     *          Verdadeiro se o descritor foi removido.
     *
     * @see TreeSet#remove
     */
    public boolean removeDescriptor(String id) {
        for(D descriptor : descriptors){
            if(descriptor.getId().equals(id))
                return descriptors.remove(descriptor);
        }
        return false;
    }
    

    /**
     * Remove um descritor da base de descritores.
     * 
     * @param descriptor
     *          elemento representando o descritor a ser removido.
     *
     * @see TreeSet#remove
     */
    public boolean removeDescriptor(D descriptor) {
        return descriptors.remove(descriptor);
    }


    /**
     * Verifica se a base de descritores contém um descritor.
     * 
     * @param descriptor
     *          elemento representando o descritor a ser verificado.
     */
    public boolean hasDescriptor(D descriptor) {
        return descriptors.contains(descriptor);
    }


    /**
     * Verifica se a base de descritores possui algum descritor.
     * 
     * @return
     *          verdadeiro se a base de descritores possuir algum descritor.
     */
    public boolean hasDescriptor() {
        return !descriptors.isEmpty();
    }


    /**
     * Retorna os descritores da base de descritores.
     *
     * @return
     *          objeto Iterable contendo os descritores da base de descritores.
     */
    public Iterable<D> getDescriptors() {
        return descriptors;
    }


    /**
     * Adiciona um importador de base à base de descritores.
     *
     * @param importBase
     *          elemento representando o importador a ser adicionado.
     *
     * @see TreeSet#add
     */
    public boolean addImportBase(I importBase) {
        return imports.add(importBase);
    }


    /**
     * Remove um importador de base da base de descritores.
     *
     * @param importBase
     *          elemento representando o importador a ser removido.
     *
     * @see TreeSet#remove
     */
    public boolean removeImportBase(I importBase) {
        return imports.remove(importBase);
    }


    /**
     * Verifica se a base de descritores contém um importador de base.
     *
     * @param importBase
     *          elemento representando o importador a ser verificado.
     */
    public boolean hasImportBase(I importBase) {
        return imports.contains(importBase);
    }


    /**
     * Verifica se a base de descritores possui algum importador de base.
     *
     * @return
     *          verdadeiro se a base de descritores possuir algum importador de base.
     */
    public boolean hasImportBase() {
        return !imports.isEmpty();
    }


    /**
     * Retorna os importadores de base da base de descritores.
     *
     * @return
     *          objeto Iterable contendo os importadores de base da base de descritores.
     */
    public Iterable<I> getImportBases() {
        return imports;
    }


    public String parse(int ident) {
        String space, content;

        if(ident < 0)
            ident = 0;

        // Element indentation
        space = "";
        for(int i = 0; i < ident; i++)
            space += "\t";

        content = space + "<descriptorBase";

        if (getId() != null)
            content += " id='" + getId() + "'";

        content += ">\n";

        if(hasImportBase()){
            for(I imp : imports)
                content += imp.parse(ident + 1);
        }

        if(hasDescriptor()){
            for(D descriptor : descriptors)
                content += descriptor.parse(ident + 1);
        }

        content += space + "</descriptorBase>\n";

        return content;
    }

}
