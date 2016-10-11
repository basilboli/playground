import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringUtilTest {

  @Test
  public void testHasAllUniqueCharacters() throws Exception {
    assertTrue (StringUtil.hasAllUniqueCharacters("bam"));
    assertFalse(StringUtil.hasAllUniqueCharacters("bamboo"));
    assertFalse(StringUtil.hasAllUniqueCharacters("lolo"));

  }

  @Test
  public void testPalindrom() throws Exception {
    // different sizes
    assertFalse(StringUtil.isPalindrom("lolom"));
    // not palindroms
    assertFalse(StringUtil.isPalindrom("lolo"));
    // palindroms
    assertTrue(StringUtil.isPalindrom("madamimadam"));
  }
}