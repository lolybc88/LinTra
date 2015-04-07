
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ImportDeclaration  extends ASTNode implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			Boolean static_;
			
			
			NamedElement importedElement; Boolean importedElementIsComposed = false;
			
			
			public ImportDeclaration(){ }
			
			
			public ImportDeclaration(
				String id,				
				Boolean static_,
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				NamedElement importedElement ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.static_ = static_ ;
				
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
			
			
			
			public void setStatic(Boolean static_) {
				this.static_ = static_;
			}
				
			public Boolean getStatic() {
				return static_;
			}
			
			
			
			public void setImportedElement(NamedElement importedElement) {
				this.importedElement = importedElement;
			}
				
			public NamedElement getImportedElement() {
				return importedElement;
			}
			
		}
	