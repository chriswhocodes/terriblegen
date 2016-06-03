package com.chrisnewland.terriblegen;

import java.io.IOException;

/*
 * "Once you admit that EVERYTHING IS TERRIBLE, the universe opens infinitely many doors for you... TO TERRIBLE."	
 *  -­ Jerry Kuch
 */
public class TerribleGen
{
	public TerribleClass createClass(String className)
	{
		return new TerribleClass(className);
	}

	public static void main(String[] args) throws IOException
	{
		TerribleGen gen = new TerribleGen();

		TerribleClass terribleClass = gen.createClass("CodeCacheBuster");

		terribleClass.createMethods(5_000);

		terribleClass.createMain(100_000);

		terribleClass.save();
	}
}