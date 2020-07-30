import java.util.HashMap;

/*****************************************************************************************
 * Directory Access (Dropbox)
 *
 * We are given a set of folders' parents folders and an access control set
 * access.
 * 
 * access is a list of directories/folders that the user has access to. If a
 * user can access a folder, all children of that folder are unlocked as well
 * All folders are locked by default
 * 
 * Given a folder folder, return true if the user has access to it, otherwise
 * return false.
 ********************************************************************************************/
public class DirectoryAccess {
    public boolean directoryAccess(String folder, Set<String> access, list<String[]> folders) {
        Map<String, String> foldermap = foldersToMap(folders);

        String curr = folders;

        while (curr != null) {
            if (access.contains(curr)) {
                return true;
            }
            curr = foldermap.get(curr);
        }

        return false;
    }

    private void foldersToMap(List<String[]> folders) {
        Map<String, String> map = new HashMap<>();

        for (String[] s : folders) {
            map.put(s[0], s[1]);
        }
    }
}