package qupath.lib.classifiers.pixel.features;

import com.google.gson.Gson;
import com.google.gson.RuntimeTypeAdapterFactory;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class FeatureCalculators {
	
	public static class FeatureCalculatorTypeAdapterFactory implements TypeAdapterFactory {

		public FeatureCalculatorTypeAdapterFactory() {}
		
		private static String typeName = "feature_calculator_type";
		
		private final static RuntimeTypeAdapterFactory<OpenCVFeatureCalculator> featureCalculatorTypeAdapter = 
				RuntimeTypeAdapterFactory.of(OpenCVFeatureCalculator.class, typeName);
		
		public static void registerSubtype(Class<? extends OpenCVFeatureCalculator> cls) {
			featureCalculatorTypeAdapter.registerSubtype(cls);
		}
		
		@Override
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
			return featureCalculatorTypeAdapter.create(gson, type);
		}
		
	}

}
