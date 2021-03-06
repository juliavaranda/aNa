/********************************************************************************
 * This file is part of the api for NCL authoring - aNa.
 *
 * Copyright (c) 2011, MídiaCom Lab (www.midiacom.uff.br)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * All advertising materials mentioning features or use of this software must
 *    display the following acknowledgement:
 *        This product includes the Api for NCL Authoring - aNa
 *        (http://joeldossantos.github.com/aNa).
 *
 *  * Neither the name of the lab nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without specific
 *    prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY MÍDIACOM LAB AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE MÍDIACOM LAB OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *******************************************************************************/
package br.uff.midiacom.ana.node;

import br.uff.midiacom.ana.NCLInvalidIdentifierException;
import br.uff.midiacom.ana.rule.NCLRule;
import org.junit.Test;
import static org.junit.Assert.*;


public class NCLBindRuleTest {

    @Test
    public void test_roleset() throws NCLInvalidIdentifierException, Exception {
        NCLSwitchBindRule nclel1, nclel2, nclel3, nclel4;
        boolean result = true;

        NCLSwitch con = new NCLSwitch("teste");

        nclel1 = new NCLSwitchBindRule();
        nclel1.setRule(new NCLRule("R1"));

        nclel2 = new NCLSwitchBindRule();
        nclel2.setRule(new NCLRule("R2"));

        nclel3 = new NCLSwitchBindRule();
        nclel3.setRule(new NCLRule("R3"));

        nclel4 = new NCLSwitchBindRule();
        nclel4.setRule(new NCLRule("R4"));

        con.addBind(nclel1);
        con.addBind(nclel2);
        con.addBind(nclel3);
        con.addBind(nclel4);

        result &= con.hasBind(nclel1);
        result &= con.hasBind(nclel2);
        result &= con.hasBind(nclel3);
        result &= con.hasBind(nclel4);

        assertTrue(result);
    }
}