package net.scharitzer;

import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

public class Config {
	public static Config fromYaml() {
		LoadSettings settings = LoadSettings.builder().build();
		Load load = new Load(settings);
		// TODO loadFromInputStream
		Config config = new Config();
		return config;
	}
}
