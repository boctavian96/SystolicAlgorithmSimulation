import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.octavian.logic.GenericMatrix;
import com.octavian.logic.SystolicMatrixMultiplication;
import com.octavian.util.HardMultiplication;

public class MatrixMultiplicationTest {

	@Test
	public void multiplyTest() {

		// TODO: Hard coded test is broken. We can test only the last step.

		SystolicMatrixMultiplication mult = new SystolicMatrixMultiplication(HardMultiplication.TEST_DATA_1,
				HardMultiplication.TEST_DATA_2);
		List<GenericMatrix> matrix1 = mult.multiplication();

		List<GenericMatrix> matrix2 = HardMultiplication.multiplicationHardcode(
				new GenericMatrix(HardMultiplication.TEST_DATA_1), new GenericMatrix(HardMultiplication.TEST_DATA_2));

		Assert.assertEquals("Arrays don't have the same size", matrix2.size(), matrix1.size());
		Assert.assertEquals("Final values isn't the same", matrix2.get(matrix2.size() - 1),
				matrix1.get(matrix1.size() - 1));

	}

}
