package cloneAndEqualsDemo;

/**
 * 
 * @author Dr. Yan-Bin Jia and Prajjwal
 *
 */
public class IntegerVector implements Cloneable{
	/**
	 * Dimension (length) of this vector.
	 */
	private int dim;

	/**
	 * The coordinates of this vector.
	 */
	private int[] coords;

	/**
	 * Constructs a zero vector of the given dimension.
	 * 
	 * @param dimension
	 * @throws IllegalArgumentException
	 *             if the dimension is less than or equal to zero
	 */
	public IntegerVector(int dimension) {
		if (dimension <= 0)
			throw new IllegalArgumentException();
		dim = dimension;
		coords = new int[dim]; // default to all zeros
	}

	/**
	 * Constructs a deep copy of the given vector.
	 * 
	 * @param existing
	 *            an existing IntVector to be copied
	 */
	public IntegerVector(IntegerVector existing) {
		//deep copy
		dim = existing.dim;
		coords = new int[dim];
		for(int i = 0; i < dim; i++) {
			coords[i] = existing.coords[i];
		}
	}

	/**
	 * Returns the coordinate at the given index.
	 * 
	 * @param index
	 *            position of the coordinate to return
	 * @return the coordinate at the given index
	 * @throws IndexOutOfBoundsException
	 *             if the given index is less than zero or is greater than or
	 *             equal to the dimension of the vector
	 */
	public int get(int index) {
		return coords[index];
	}

	/**
	 * Sets the coordinate at the given index to the given value.
	 * 
	 * @param index
	 *            position of the coordinate to set
	 * @param value
	 *            the coordinate's new value
	 * @throws IndexOutOfBoundsException
	 *             if the given index is less than zero or is greater than or
	 *             equal to the dimension of the vector
	 */
	public void set(int index, int value) {
		coords[index] = value;
	}

	/**
	 * Returns the dimension of this vector.
	 * 
	 * @return the dimension of this vector.
	 */
	public int dimension() {
		return dim;
	}

	/**
	 * Returns the dot product of this vector and the given vector.
	 * 
	 * @param v
	 *            the given vector
	 * @throws IllegalArgumentException
	 *             if the given vector does not have the same dimension as this
	 *             vector
	 */
	public int dotProduct(IntegerVector v) {
		int result = 0;
		for (int i = 0; i < v.dim; ++i) {
			result += coords[i] * v.coords[i];
		}
		return result;
	}

	/**
	 * Determines whether this vector is equal to the given Object.
	 * 
	 * @return true if the given Object is an IntVector with the same dimension
	 *         and the same coordinates as this one.
	 */
	@Override
	public boolean equals(Object obj) {
		//equals
		// null check
		if(obj == null) {
			return false;
		}
		//type check
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		//downcast, we know it is safe from last step
		IntegerVector v = (IntegerVector) obj;
		// check contents are equal
		if (dim != v.dim) {
			return false;
		}
		for(int i = 0; i < dim; i++) {
			if(coords[i] != v.coords[i]) {
				return false;
			}
		
		}
		return true;
	}

	/**
	 * Creates a deep copy of this vector.
	 * 
	 * @return a deep copy of this object.
	 */
	@Override
	public IntegerVector clone() throws CloneNotSupportedException {
		//deep copy
		IntegerVector copy = (IntegerVector) super.clone(); // shallow clone only
		//create a deep copy of reference type variables
		copy.coords = new int[dim];
		for(int i = 0; i < dim; i++) {
			copy.coords[i] = coords[i];
		}
		return copy;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		for(int i = 0; i < dim; i++) {
			str += coords[i] + " ";
		}
		return str;
	}
}
