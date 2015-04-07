
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class TypeAccess  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Type type; Boolean typeIsComposed = false;
			
			NamespaceAccess qualifier; Boolean qualifierIsComposed = true;
			
			
			public TypeAccess(){ }
			
			
			public TypeAccess(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Type type,				NamespaceAccess qualifier ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.type = type ;
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
			
			
			
			
			
			public void setType(Type type) {
				this.type = type;
			}
				
			public Type getType() {
				return type;
			}
			
			public void setQualifier(NamespaceAccess qualifier) {
				this.qualifier = qualifier;
			}
				
			public NamespaceAccess getQualifier() {
				return qualifier;
			}
			
		}
	