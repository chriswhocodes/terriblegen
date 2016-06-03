package com.chrisnewland.terriblegen;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TerribleClass
{
	private String className;

	private List<TerribleMethod> methods;

	private TerribleMain main;

	public TerribleClass(String className)
	{
		this.className = className;
	}

	public void createMethods(int count)
	{
		methods = new ArrayList<>(count);

		for (int i = 0; i < count; i++)
		{
			methods.add(new TerribleMethod(i, count));
		}
	}

	public void createMain(int invocations)
	{
		main = new TerribleMain(className, methods.size(), invocations);
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		builder.append("import java.util.Random;").append("\n").append("\n");

		builder.append("public class ").append(className).append("\n");
		builder.append("{").append("\n");

		builder.append("Random random = new Random();").append("\n").append("\n");

		for (TerribleMethod method : methods)
		{
			builder.append(method.toString()).append("\n");
		}

		builder.append(main.toString()).append("\n");

		builder.append("}").append("\n");

		return builder.toString();
	}

	public void save() throws IOException
	{
		Files.write(Paths.get(className + ".java"), this.toString().getBytes(StandardCharsets.UTF_8));
	}
}
