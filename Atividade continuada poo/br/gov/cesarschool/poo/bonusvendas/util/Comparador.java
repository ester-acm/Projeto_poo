package br.gov.cesarschool.poo.bonusvendas.util;

public interface Comparador {

	//interfaces can only have abstract methods
	//An interface is a completely "abstract class" that is used to group
	//related methods with empty bodies:
	//Like abstract classes, interfaces cannot be used to create objects (in the example above, it is not possible to create an "Animal" object in the MyMainClass)
	//Interface methods do not have a body - the body is provided by the "implement" class
	//On implementation of an interface, you must override all of its methods
	//Interface methods are by default abstract and public
	//Interface attributes are by default public, static and final
	//An interface cannot contain a constructor (as it cannot be used to create objects)
	public int comparar(Object o1, Object o2);
}