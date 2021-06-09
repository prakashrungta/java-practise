import java.util.Objects;

public class ImmutablePair<T, U> {

	private final T a;
	private final U b;

	public ImmutablePair(T a, U b) {
		this.a = a;
		this.b = b;
	}

	public T getA() {
		return a;
	}

	public U getB() {
		return b;
	}

	public static <T, U> ImmutablePair<T, U> of(T a, U b) {
		return new ImmutablePair<T, U>(a, b);
	}

	@Override
	public String toString() {
		return "ImmutablePair [a=" + a + ", b=" + b + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ImmutablePair<?, ?> other = (ImmutablePair<?, ?>) obj;
		return Objects.equals(a, other.a) && Objects.equals(b, other.b);
	}
}