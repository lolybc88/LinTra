
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class MemberRef  extends ASTNode implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			NamedElement member; Boolean memberIsComposed = false;
			
			TypeAccess qualifier; Boolean qualifierIsComposed = true;
			
			
			public MemberRef(){ }
			
			
			public MemberRef(
				String id,				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				NamedElement member,				TypeAccess qualifier ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.member = member ;
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
			
			
			
			
			
			public void setMember(NamedElement member) {
				this.member = member;
			}
				
			public NamedElement getMember() {
				return member;
			}
			
			public void setQualifier(TypeAccess qualifier) {
				this.qualifier = qualifier;
			}
				
			public TypeAccess getQualifier() {
				return qualifier;
			}
			
		}
	