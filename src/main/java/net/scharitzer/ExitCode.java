package net.scharitzer;

public enum ExitCode {
	SUCCESS(0),
	FAILURE(1);

	private final int value;
	public int value() { return value; }

	ExitCode(int value) { this.value = value; }
}
