import java.io.File;


public class FileDirTest {

	public static void main(String[] args) {
		File fRootDir = new File("F:/wiseu_package/hufs_wiseu55/spool");
		checkFileWhenTimeIsDelete(fRootDir);
	}
	
	
	
	private static void checkFileWhenTimeIsDelete(File fRootDir) {
		if( fRootDir.isDirectory() ) {
			File[] fDir = fRootDir.listFiles();
			for( int i = 0 ; i < fDir.length ; i++ ) {
				if( fDir[i].isDirectory() ) {
					checkFileWhenTimeIsDelete(fDir[i]);
				}else {
//					long lLastModifyDt = fDir[i].lastModified();
//					long lPreservePeriod = iLimitPreservePeriod * 24 * 60 * 60 * 1000;

					String sTmpFileNm = fDir[i].getName();
					System.out.println("> File : " + sTmpFileNm);
				
					if(sTmpFileNm.endsWith(".fs")||sTmpFileNm.endsWith(".csv")) continue;
					
					if(sTmpFileNm.endsWith("er.uploadbad")) {
						System.out.println("[SpoolCleanBatch] " + fDir[i].getAbsolutePath() + "[ File ]");
						continue;
					}
					fDir[i].delete();
					
//					if( lToday - lLastModifyDt > lPreservePeriod ) {
//						fDir[i].delete();
//						logger.info("[SpoolCleanBatch] " + fDir[i].getAbsolutePath() + " deleted");
//					}
				}
			}
		}
	}
}
