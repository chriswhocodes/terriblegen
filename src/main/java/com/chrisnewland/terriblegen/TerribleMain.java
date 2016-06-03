package com.chrisnewland.terriblegen;

public class TerribleMain
{
	private String className;
	private int methodCount;
	private int iterations;

	public TerribleMain(String className, int methodCount, int iterations)
	{
		this.className = className;
		this.methodCount = methodCount;
		this.iterations = iterations;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		builder.append("public static void main(String[] args)").append("\n");
		builder.append("{").append("\n");

		String instance = className.toLowerCase();

		builder.append("\t").append(className).append(" ").append(instance).append(" = new ").append(className).append("();")
				.append("\n");
		builder.append("\n");
		builder.append("\t").append("int sum = 0;").append("\n");
		builder.append("\n");
		builder.append("\t").append("for (int i = 0; i < ").append(iterations).append("; i++)").append("\n");
		builder.append("\t{").append("\n");

		for (int i = 0; i < methodCount; i++)
		{
			builder.append("\t\tsum += ").append(instance).append(".t").append(i).append("(sum);").append("\n");
		}

		builder.append("\t}").append("\n");

		builder.append("\tSystem.out.println(\"sum = \" + sum);").append("\n");

		builder.append("}").append("\n");

		return builder.toString();
	}
}