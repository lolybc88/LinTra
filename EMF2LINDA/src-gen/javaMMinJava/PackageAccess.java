
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class PackageAccess  extends NamespaceAccess implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Package package; Boolean packageIsComposed = false;
			
			PackageAccess qualifier; Boolean qualifierIsComposed = true;
			
			
			public PackageAccess(){ }
			
			
			public PackageAccess(
				String id,				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Package package,				PackageAccess qualifier ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.package = package ;
				this.qualifier = qualifier ;
			}
			
			
			
			public String getId() {
   				return id;
			}

			public void setId(String id) {
   				this.id = id;
			}
			
			public String getTrgId() {
   				return trgId;
			}

			public void setTrgId(String trgId) {
   				this.trgId = trgId;
			}
			
			
			
			
			
			public void setPackage(Package package) {
				this.package = package;
			}
				
			public Package getPackage() {
				return package;
			}
			
			public void setQualifier(PackageAccess qualifier) {
				this.qualifier = qualifier;
			}
				
			public PackageAccess getQualifier() {
				return qualifier;
			}
			
		}
	