import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class FolderFileList {

	static HashSet<String> hsCITY;
	static int cnt;

	public static void main(String[] args) {
		String srcCITY = "Z:\\°í°´»ç\\CITY\\CITY_web_source_¿øº»\\classes-CITY\\com";
		String srcSVN = "Z:\\°í°´»ç\\CITY\\CITY_web_source_¿øº»\\classes-SVN\\com";

		hsCITY = new HashSet<String>();
		subDirList(srcCITY, true);
		System.out.println();
		System.out.println(cnt);
		cnt = 0;
		subDirList(srcSVN, false);

		System.out.println(cnt);
	}

	public static void subDirList(String source, boolean flag) {
		File dir = new File(source);
		File[] fileList = dir.listFiles();
		String srcFile = "";
		String cityFileNm = "";
		try {
			for (int i = 0; i < fileList.length; i++) {
				File file = fileList[i];
				cityFileNm = "";

				if (file.isFile()) {
					srcFile = file.getName();

					cnt++;

					if (flag) {
						hsCITY.add(srcFile);
						System.out.print(".");
					} else {
						if (hsCITY.contains(srcFile))
							cityFileNm = srcFile;
						System.out.println(file.getParent() + "\t" + srcFile
								+ "\t" + cityFileNm);
					}
				} else if (file.isDirectory()) {
					subDirList(file.getCanonicalPath().toString(), flag);
				}
			}
		} catch (IOException e) {

		}

	}

}
