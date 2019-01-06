import org.junit.Assert;
import org.junit.Test;

import com.octavian.logic.GenericMatrix;
import com.octavian.logic.MatrixGenerator;

public class MatrixGeneratorTest {

	@Test
	public void testGenerateMatrix() {
		GenericMatrix genericMatrix = MatrixGenerator.generateMatrix();

		Assert.assertTrue("Generic Matrix is null", genericMatrix != null);

		System.out.print("The Generic Matrix is: \n" + genericMatrix);
	}

}
