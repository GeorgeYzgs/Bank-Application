/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

/**
 *
 * @author George.Giazitzis
 */
public interface IBaserate {

    default double getBaseRate() {
        return 2.5;
    }
}
