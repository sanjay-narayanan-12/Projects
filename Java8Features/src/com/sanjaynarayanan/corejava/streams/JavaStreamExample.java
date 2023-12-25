package com.sanjaynarayanan.corejava.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamExample {

	static final List<Product> productsList = Arrays.asList(new Product(1, "HP Laptop", 25000f),
			new Product(2, "Dell Laptop", 30000f), new Product(3, "Lenevo Laptop", 28000f),
			new Product(4, "Sony Laptop", 28000f), new Product(5, "Apple Laptop", 90000f));

	public JavaStreamExample() {
		System.out.println("-------------Before Stream--------------");
		beforeStream();
		System.out.println("-------------Before Stream--------------");
		System.out.println("-------------Using Stream--------------");
		usingStream();
		System.out.println("-------------Using Stream--------------");
		System.out.println("-------------Iterate Stream--------------");
		iterateStream();
		System.out.println("-------------Iterate Stream--------------");
		System.out.println("-------------Reduce method Stream--------------");
		reduceMethodStream();
		System.out.println("-------------Reduce method Stream--------------");
		System.out.println("-------------Sum by collectors method Stream--------------");
		sumByCollectors();
		System.out.println("-------------Sum by collectors method Stream--------------");
		System.out.println("-------------Find minimum and maximum price of products--------------");
		findMinAndMaxValue();
		System.out.println("-------------Find minimum and maximum price of products--------------");
		System.out.println("-------------Covert stream collections of products--------------");
		convertStreamCollections();
		System.out.println("-------------Covert stream collections of products--------------");
		System.out.println("-------------Method Reference in stream--------------");
		methodReference();
		System.out.println("-------------Method Reference in stream--------------");
	}

	/**
	 * Before Stream of Java 8
	 */
	public static void beforeStream() {
		List<Float> productPriceList = new ArrayList<Float>();
		for (Product product : productsList) {
			// filtering data of list
			if (product.price < 30000) {
				productPriceList.add(product.price); // adding price to a productPriceList
			}
		}
		System.out.println(productPriceList + "\n"); // displaying data
	}

	/**
	 * we are filtering data by using stream. You can see that code is optimized and
	 * maintained. Stream provides fast execution.
	 */
	public static void usingStream() {
		List<Float> productPriceList2 = productsList.stream().filter(p -> (p.price > 30000 || p.price == 3000))// filtering
																												// data
				.map(p -> p.price) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList2);
	}

	/**
	 * Iterated method
	 */
	public static void iterateStream() {

		/**
		 * You can use stream to iterate any number of times. Stream provides predefined
		 * methods to deal with the logic you implement. In the following example, we
		 * are iterating, filtering and passed a limit to fix the iteration.
		 */
		Stream.iterate(1, element -> element + 1).filter(element -> element % 5 == 0).limit(2)
				.forEach(System.out::println);

		System.out.println("Filtering and Iterating Collections : ");

		/**
		 * we are using filter() method. Here, you can see code is optimized and very
		 * concise.
		 */
		// This is more compact approach for filtering data
		productsList.stream().filter(product -> product.price >= 30000)
				.forEach(product -> System.out.println(product.name));

	}

	/**
	 * This method takes a sequence of input elements and combines them into a
	 * single summary result by repeated operation. For example, finding the sum of
	 * numbers, or accumulating elements into a list.
	 * 
	 * In the following example, we are using reduce() method, which is used to sum
	 * of all the product prices.
	 */
	public static void reduceMethodStream() {
		// This is more compact approach for filtering data
		Float totalPrice = productsList.stream().map(product -> product.price).reduce(0.0f,
				(sum, price) -> sum + price); // accumulating price
		System.out.println("Total Price : " + totalPrice);
		// More precise code, accumulating price, by referring method of Float class
		Float totalPrice2 = productsList.stream().map(product -> product.price).reduce(0.0f, Float::sum);
		System.out.println("Total Price using method reference : " + totalPrice2);

	}

	/**
	 * Sum by using Collectors Methods. We can also use collectors to compute sum of
	 * numeric values. In the following example, we are using Collectors class and
	 * it?s specified methods to compute sum of all the product prices
	 */
	public static void sumByCollectors() {
		// Using Collectors's method to sum the prices.
		double totalPrice = productsList.stream().collect(Collectors.summingDouble(product -> product.price));
		System.out.println("Total Price : " + totalPrice);
	}

	/**
	 * Find Max and Min Product Price Following example finds min and max product
	 * price by using stream. It provides convenient way to find values without
	 * using imperative approach.
	 */
	public static void findMinAndMaxValue() {
		Product productA = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1)
				.get();
		System.out.println("Maximum value : " + productA.price);
		// min() method to get min Product price
		Product productB = productsList.stream().min((product1, product2) -> product1.price > product2.price ? 1 : -1)
				.get();
		System.out.println("Minimum value : " + productB.price);
		/**
		 * count() Method in Collection
		 */
		// count number of products based on the filter
		long count = productsList.stream().filter(product -> product.price < 30000).count();
		System.out.println("No.of.products above 30000 : " + count);
	}

	/**
	 * stream allows you to collect your result in any various forms. You can get
	 * you result as set, list or map and can perform manipulation on the elements.
	 */
	public static void convertStreamCollections() {
		/**
		 * Converting product List into Set
		 */
		Set<Float> productPriceList = productsList.stream().filter(product -> product.price < 30000)
				// filter product on the base of price
				.map(product -> product.price).collect(Collectors.toSet());
		// collect it as Set(remove duplicate elements)
		System.out.println("Convert Stream list to set : " + productPriceList);
		/**
		 * Converting product List into a Map
		 */
		Map<Integer, String> productPriceMap = productsList.stream().filter(product -> product.price < 30000)
				.collect(Collectors.toMap(p -> p.id, p -> p.name));
		System.out.println("Convert Stream list to map : " + productPriceMap);
	}

	/**
	 * Method Reference in stream
	 */
	public static void methodReference() {
		List<Float> productPriceList = productsList.stream().filter(p -> p.price < 30000) // filtering data
				.map(Product::getPrice) // fetching price by referring getPrice method
				.collect(Collectors.toList()); // collecting as list
		System.out.println("Method Reference in stream : " + productPriceList);
	}
}
