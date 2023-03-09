/*
Copyright Ann Barcomb and Emily Marasco, 2023
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package ex14Lab.edu.ucalgary.oop;

class SingleUseMethodException extends Exception {
    public SingleUseMethodException() {
        super("Method can only be called once per instantiation");
    }
}