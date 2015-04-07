
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ImportDeclaration  extends ASTNode implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			Boolean static;
			
			
			NamedElement importedElement; Boolean importedElementIsComposed = false;
			
			
			public ImportDeclaration(){ }
			
			
			public ImportDeclaration(
				String id,				
				Boolean static
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				NamedElement importedElement ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.static = static ;
				
				this.importedElement = importedElement ;
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
			
			
			
			public void setStatic(Boolean static) {
				this.static = static;
			}
				
			public Boolean getStatic() {
				return static;
			}
			
			
			
			public void setImportedElement(NamedElement importedElement) {
				this.importedElement = importedElement;
			}
				
			public NamedElement getImportedElement() {
				return importedElement;
			}
			
		}
	