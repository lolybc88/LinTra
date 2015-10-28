package javaMMinJava;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public abstract class Type extends NamedElement implements Serializable, IdentifiableElement, IType {

	private static final long serialVersionUID = 1L;

	String[] usagesInTypeAccessID;
	Boolean usagesInTypeAccessIsComposed = false;

	public Type() {
	}

	public Type(String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID, String name, Boolean proxy,
			String[] usagesInImportsID, String[] usagesInTypeAccessID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.usagesInTypeAccessID = usagesInTypeAccessID;
	}

	public void setUsagesInTypeAccess(String[] usagesInTypeAccessID) {
		this.usagesInTypeAccessID = usagesInTypeAccessID;
	}

	public String[] getUsagesInTypeAccess() {
		return usagesInTypeAccessID;
	}

	@Override
	public String toString() {
		return "Type [usagesInTypeAccessID="
				+ Arrays.toString(usagesInTypeAccessID)
				+ ", usagesInTypeAccessIsComposed="
				+ usagesInTypeAccessIsComposed + ", name=" + name + ", proxy="
				+ proxy + ", usagesInImportsID="
				+ Arrays.toString(usagesInImportsID)
				+ ", usagesInImportsIsComposed=" + usagesInImportsIsComposed
				+ ", commentsID=" + Arrays.toString(commentsID)
				+ ", commentsIsComposed=" + commentsIsComposed
				+ ", originalCompilationUnitID=" + originalCompilationUnitID
				+ ", originalCompilationUnitIsComposed="
				+ originalCompilationUnitIsComposed + ", originalClassFileID="
				+ originalClassFileID + ", originalClassFileIsComposed="
				+ originalClassFileIsComposed + "]";
	}
	
	

}
