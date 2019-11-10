package main;

import client.Client;
import prototype.ConcretePrototype1;
import prototype.IPrototype;

public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		ConcretePrototype1 cp1 = new ConcretePrototype1('~');
		ConcretePrototype1 cp2 = new ConcretePrototype1('*');
		ConcretePrototype1 cp3 = new ConcretePrototype1('/');
		client.register("Strong message", cp1);
		client.register("Waring Box", cp2);
		client.register("Slash Box", cp3);
		IPrototype p1 = client.create("Strong message");
		p1.use("hello world");
		
		IPrototype p2 = client.create("Waring Box");
		p2.use("hello world");
		
		IPrototype p3 = client.create("Slash Box");
		p3.use("hello world");
	}
}
